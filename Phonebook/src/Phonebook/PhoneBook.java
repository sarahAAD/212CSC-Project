package Phonebook;

public class PhoneBook {
    LinkedList<Contact> ContactLinkedList = new LinkedList<>();



  
    public boolean AddContact(Contact contact){
        if(ContactLinkedList.empty())
            ContactLinkedList.insert(contact);
        ContactLinkedList.FindFirst();
        while(!ContactLinkedList.last()){
            if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())&&ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber()) )
                return false;
            ContactLinkedList.FindNext();
        } if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())&&ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber()) )
             return false;
        else {
          ContactLinkedList.insert(contact);
          return true;}
    }
    
  
}
