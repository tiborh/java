package ps3;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;

/**
 * Book is an immutable type representing an edition of a book -- not the physical object, 
 * but the combination of words and pictures that make up a book.  Each book is uniquely
 * identified by its title, author list, and publication year.  Alphabetic case and author 
 * order are significant, so a book written by "Fred" is different than a book written by "FRED".
 */
public class Book implements Comparable<Book> {
    private static final String REGEX = ".*\\S+.*";
    // rep
    private final String title;
    private final List<String> authors;
    private final int year;

    // rep invariant
    // Title must contain at least one non-space character.
    // Author list must have at least one name, and each name must contain at least one non-space character.
    // Publication year is in the conventional (Common Era) calendar, so must be nonnegative.
    
    // abstraction function
    // Represents a book determined by its Title, Authors, and Year of Publication
    
    // safety from rep exposure argument
    // all fields are private
    // only an immutable view of the List is returned with get.authors
    // title is String, so immutable
    // year is a primitive so "final" makes it effectively immutable

    /**
     * Make a Book.
     * @param title Title of the book. Must contain at least one non-space character.
     * @param authors Names of the authors of the book.  Must have at least one name, and each name must contain 
     * at least one non-space character.
     * @param year Year when this edition was published in the conventional (Common Era) calendar.  Must be nonnegative. 
     */
    public Book(String title, List<String> authors, int year) {
        this.title = new String(title);
        this.authors = Collections.unmodifiableList(authors);
        this.year = year;
        checkRep();
    }

    private void stringCheck(String s) {
        assert(s != null);
        assert(s.length() > 0);
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(s);
        assert(m.find());
    }

    // assert the rep invariant
    private void checkRep() {
        assert(year >= 0);
        stringCheck(title);
        for (String anAuthor : authors)
            stringCheck(anAuthor);
    }

    /**
     * @return the title of this book
     */
    public String getTitle() {
        return new String(title);
    }

    /**
     * @return the authors of this book
     */
    public List<String> getAuthors() {
        List<String> outList = new ArrayList<String>(authors.size());
        for (String anAuthor : authors)
            outList.add(anAuthor);
        return outList;
    }

    /**
     * @return the year that this book was published
     */
    public int getYear() {
        return year;
    }

    /**
     * @return human-readable representation of this book that includes its title,
     *    authors, and publication year
     */
    public String toString() {
        return new String(title + " by " + authors + ", " + year);
    }
    
    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;        
        if (super.equals(that)) return true;
        if (!(that instanceof Book)) return false;
        if (!Book.class.isAssignableFrom(that.getClass())) return false;
        
        final Book other = (Book) that;
        if (this.title.equals(other.getTitle())) {
            if (this.year == other.getYear()) {
                if (this.authors.size() == other.getAuthors().size()) {
                    for (int i = 0; i < authors.size(); ++i) {
                        if (! authors.get(i).equals(other.getAuthors().get(i))) {
                            return false;
                        }
                    }
                } else { return false; }
            } else { return false; }
            return true;
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        sum += title.length();
        for (String anAuthor : authors)
            sum += anAuthor.length();
        sum += year;
        return(sum);
    }

    @Override
    public int compareTo(Book other) {
        int titleComp = this.getTitle().compareTo(other.getTitle());
        if (titleComp != 0) return titleComp;
        int authorComp = compareAuthors(other.getAuthors());
        if (authorComp != 0) return authorComp;
        int yearComp = other.getYear() - this.getYear();
        return yearComp;
    }
    
    private int compareAuthors(List<String> other) {
        int thisSize = this.authors.size();
        int otherSize = other.size();
        int smallerSize = thisSize < otherSize ? thisSize : otherSize;
        
        for (int i = 0; i < smallerSize; ++i) {
            int compResult = this.authors.get(i).compareTo(other.get(i));
            if (compResult != 0)
                return compResult;
        }
        
        if (thisSize != otherSize)
            return thisSize - otherSize;

        return 0;
    }

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */

}