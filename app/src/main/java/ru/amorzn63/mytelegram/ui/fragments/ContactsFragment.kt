package ru.amorzn63.mytelegram.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.contact_item.view.*
import kotlinx.android.synthetic.main.fragment_contacts.*
import ru.amorzn63.mytelegram.R
import ru.amorzn63.mytelegram.models.CommonModel
import ru.amorzn63.mytelegram.utilits.*


class ContactsFragment : BaseFragment(R.layout.fragment_contacts) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: FirebaseRecyclerAdapter<CommonModel, ContactsHolder>
    private lateinit var mRefContacts: DatabaseReference  // откуда скачивать данные
    private lateinit var mRefUser: DatabaseReference  // ссылка на юзера
    private lateinit var mRefUserListener: AppValueEventListener                     //устранение утечки памяти
    private var mapListener =
        hashMapOf<DatabaseReference, AppValueEventListener>()  //устранение утечки памяти


    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Контакты"
        initRecyclerView()
    }

    private fun initRecyclerView() {
        mRecyclerView = contacts_recycle_view
        mRefContacts = REF_DATABASE_ROOT.child(NODE_PHONES_CONTACTS).child(CURRENT_UID)

        val options = FirebaseRecyclerOptions.Builder<CommonModel>()
            .setQuery(mRefContacts, CommonModel::class.java)
            .build()
        mAdapter = object : FirebaseRecyclerAdapter<CommonModel, ContactsHolder>(options) {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.contact_item, parent, false)
                return ContactsHolder(view)

            }

            override fun onBindViewHolder(
                holder: ContactsHolder,
                position: Int,
                model: CommonModel
            ) {
                mRefUser = REF_DATABASE_ROOT.child(NODE_USERS).child(model.id)

                mRefUserListener = AppValueEventListener {
                    val contact =
                        it.getCommonModel()  // создаем модельку для отображения информации
                    holder.name.text = contact.fullname
                    holder.status.text = contact.state
                    holder.photo.downloadAndSetImage(contact.photoUrl)
                    holder.itemView.setOnClickListener { replaceFragment(SingleChatFragment(contact)) }
                }

                mRefUser.addValueEventListener(mRefUserListener)
                mapListener[mRefUser] = mRefUserListener      //устранение утечки памяти

            }
        }
        mRecyclerView.adapter = mAdapter   // подключаем адаптер к списку
        mAdapter.startListening()    // ставим на адаптер слушатель - запускаем адаптер
    }

    class ContactsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.contact_fullname
        val status: TextView = view.contact_state
        val photo: CircleImageView = view.contact_photo
    }

    override fun onPause() {
        super.onPause()
        mAdapter.stopListening()  // останавливаем адаптер
        mapListener.forEach {
            it.key.removeEventListener(it.value)   //устранение утечки памяти
        }
    }
}


