package com.aniljadhav2833.mysite.mysiteBackend.services;

import com.aniljadhav2833.mysite.mysiteBackend.model.ContactMessage;
import com.aniljadhav2833.mysite.mysiteBackend.repository.ContactMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    ContactMessageRepo contactMessageRepo;

    public ContactMessage checkMessage(int id){
        return contactMessageRepo.findById(id).orElse(null);
    }

    public List<ContactMessage> checkAllMessage(){
        return contactMessageRepo.findAll();
    }

    public List<ContactMessage> checkAllMessageWithReplyStatus(boolean isReplied){
        return contactMessageRepo.findByReplied(isReplied);
    }

    public ContactMessage sendMessage(ContactMessage contactMessage){
        contactMessage.setMessageDateTime(LocalDateTime.now());
        return contactMessageRepo.save(contactMessage);
    }

    public ContactMessage updateMessage(int id, String reply){
        ContactMessage contact = checkMessage(id);
        if(contact != null && !contact.isReplied()){
            contact.setRepliedMessage(reply);
        contact.setReplyeDateTime(LocalDateTime.now());
        contact.setReplied(true);
           String replier = SecurityContextHolder.getContext().getAuthentication().getName();
           if(replier != null)
           contact.setReplierName(replier);
            contactMessageRepo.save(contact);
        }
        return contact;
    }


}
