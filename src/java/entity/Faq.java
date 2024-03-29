package entity;
// Generated Sep 3, 2019 7:58:03 PM by Hibernate Tools 3.6.0


import java.io.Serializable;
import java.util.Date;

/**
 * Faq generated by hbm2java
 */
public class Faq  implements java.io.Serializable {


     private int faqId;
     private String question;
     private String answer;
     private Date created;
     private boolean isDisabled;

    public Faq() {
    }

    public Faq(int faqId, String question, String answer, Date created, boolean isDisabled) {
       this.faqId = faqId;
       this.question = question;
       this.answer = answer;
       this.created = created;
       this.isDisabled = isDisabled;
    }
   
    public int getFaqId() {
        return this.faqId;
    }
    
    public void setFaqId(int faqId) {
        this.faqId = faqId;
    }
    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    public boolean isIsDisabled() {
        return this.isDisabled;
    }
    
    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }




}


