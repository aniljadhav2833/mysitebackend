package com.aniljadhav2833.mysite.mysiteBackend.controller;

import com.aniljadhav2833.mysite.mysiteBackend.model.ContactMessage;
import com.aniljadhav2833.mysite.mysiteBackend.services.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200" ,allowedHeaders = "Authorization, Content-Type")
public class ContactController {
    @Autowired
    ContactMessageService contactMessageService;

    @GetMapping("/api/test")
    public String testEndpoint() {
        return "CORS";
    }


    @PostMapping("/sendmessage")
    public ResponseEntity<?> addContact(@RequestBody ContactMessage contactMessage){
      ContactMessage contact=  contactMessageService.sendMessage(contactMessage);
      if(contact != null)
      return new ResponseEntity<>(contact, HttpStatus.CREATED);
        return new ResponseEntity<>("Sometimg is incorrect in request, Kindly re-check", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/checkMessage/{id}")
    public ResponseEntity<?> checkMessage(@PathVariable int id){
        ContactMessage contact=  contactMessageService.checkMessage(id);
        if(contact != null)
            return new ResponseEntity<>(contact, HttpStatus.OK);
        return new ResponseEntity<>("No data available with message id = "+id, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/checkMessage")
    public ResponseEntity<?>  checkMessage(@RequestParam String reply){
        boolean isreplyConvert = reply.equalsIgnoreCase("TRUE");
        List<ContactMessage> contacts=  contactMessageService.checkAllMessageWithReplyStatus(isreplyConvert);
        if(contacts != null)
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        return new ResponseEntity<>("No data available with status pending for reply", HttpStatus.NOT_FOUND);
    }

    @PostMapping("updatemessage/{id}")
    public ResponseEntity<?> updateContact(@PathVariable int id, @RequestParam(required = false) String reply){
        ContactMessage contact= contactMessageService.updateMessage(id, reply);
        if(contact != null)
            return new ResponseEntity<>(contact, HttpStatus.OK);
        return new ResponseEntity<>("No data available with message id = "+id +" hence not modified", HttpStatus.NOT_MODIFIED);
    }
}
