/**
 * Created by GraysonMartis on 4/2/16.
 */
import java.util.*;
public class DynamicBuffer {
    private int initSize;//initial size of array
    private int aSize;  //current size of array
    private Email[] emailArray; //array of emails
    private int numEmails = 0; //number of emails in array

    //The buffer will have an array with an initial size.
    //You can choose whatever initial size you want.
    public DynamicBuffer(int initSize) {
        this.initSize = initSize;
        emailArray = new Email[initSize];
        aSize = emailArray.length;
    }

    //Returns the number of emails stored in the array
    public int numElements() {
        return numEmails;
    }

    //Returns the length of the array
    public int getBufferSize() {
        return emailArray.length;
    }

    //Adds an email to the array
    // If the array becomes full by adding this email double its size.
    public void add(Email email) {
        if (numEmails == aSize) {
            aSize = aSize * 2;
            emailArray = Arrays.copyOf(emailArray, aSize);
        }
        emailArray[numEmails++] = email;
    }

    //Removes an email at the specified index from the buffer
    //Return true if the index is valid and an email is removed; else return false.
    // If the number of emails in the buffer becomes less than or equal to one fourth of the buffer size after the removal, shrink the buffer size to half of the current buffer size.
    //Note that the buffer size should never be lower than the initial size.
    public boolean remove(int index) {
        if ((numEmails - 1) == index) {
            for (int i = 0; i < aSize - 1; i++) {
                if (emailArray[i] == emailArray[index]) {
                    for (int j = i; j < aSize - 1; j++) {
                        emailArray[j] = emailArray[j + 1];
                    }
                }
            }
            emailArray[aSize - 1] = null;
            numEmails--;
            if (numEmails <= (emailArray.length / 4)) {
                aSize = aSize / 2;
                if (aSize < initSize) {
                    aSize = initSize;
                }
                emailArray = Arrays.copyOf(emailArray, aSize);
            }
            return true;
        }
        else {
            return false;
        }
    }

    //Gets the n most recently added Emails to the buffer (the last n)
    //Returned emails must be sorted from most recently to least recently added to the buffer.
    //Return all emails if n is greater than the number of emails in the buffer
    //Return null if the buffer is empty or an invalid number of emails is requested (e.g. -1)
    public Email[] getNewest(int n) {
        if (n <= 0) {
            return null;
        }
    }


}
