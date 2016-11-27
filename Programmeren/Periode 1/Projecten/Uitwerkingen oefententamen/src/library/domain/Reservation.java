/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.domain;

import java.util.Date;

/**
 *
 * @author ppthgast
 */
public class Reservation {
    private Date reservationDate;
    
    private Member member;
    private Book book;
    
    public Reservation(Member member, Book book)
    {
        this.member = member;
        this.book = book;
    }
    
    public Member getMember()
    {
        return member;
    }
    
    public Book getBook()
    {
        return book;
    }
    
    public void setReservationDate(Date reservationDate)
    {
        this.reservationDate = reservationDate;
    }
    
    public Date getRetourDatum()
    {
        return reservationDate;
    }
    
    public void remove()
    {
        // Removing this reservation means unlinking from the member and the
        // book. The garbage collection mechanism will detect that there are
        // no more references to this object and consequently will remove it
        // from memory. To clean up nicely, the book and member fields are
        // set to null (the relations are bidirectional).
        member.removeReservation(this);
        member = null;
        
        book.removeReservation(this);
        book = null;
    }
    
    @Override
    public boolean equals(Object o)
    {
        boolean equal = false;
        
        if(o == this)
        {
            // Dezelfde instantie van de klasse, dus per definitie hetzelfde.
            equal = true;
        }
        else
        {
            if(o instanceof Reservation)
            {
                Reservation r = (Reservation)o;
                
                equal = reservationDate.equals(r.reservationDate) &&
                        member.equals(r.member) &&
                        book.equals(r.book);
            }
        }
        
        return equal;
    }
    
    @Override
    public int hashCode()
    {
        // Deze implementatie is gebaseerd op de best practice zoals beschreven
        // in Effective Java, 2nd edition, Joshua Bloch.
        
        int result = 17;
        result += reservationDate.hashCode() +
                member.hashCode() +
                book.hashCode();
        
        return result;
    }
}
