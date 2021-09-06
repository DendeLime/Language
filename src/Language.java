import java.util.*;
import java.util.stream.Stream;

/**
 * Represents a finite language.
 *
 * @author Dr. Jody Paul
 * @author Denver Grevious
 * @version 1.0
 */
public final class Language implements Iterable<String>, java.io.Serializable {
    /** The empty string. */
    private static final String EMPTY_STRING = "";
    /** The empty set. */
    private static final Set<String> EMPTY_SET = new TreeSet<>();

    /** The set of strings in this language, initially empty. */
    private Set<String> strings;

    /**
     * Create a language with no strings.
     */
    public Language() {

        strings = new TreeSet<String>();

    }

    /**
     * Indicates if this language has no strings.
     * @return true if the language is equivalent to the empty set;
     *         false otherwise
     */
    public boolean isEmpty() {

        boolean value = false;

        if (strings.isEmpty()) {
            value = true;
        }
        return value;


    }

    /**
     * Accesses the number of strings (cardinality) in this language.
     * @return the cardinality of the language
     */
    public int cardinality() {
        int count;

        if (isEmpty()) {
            count = 0;
            return count;
        }
        else {
            count = strings.size();
        }
        return count;
    }

    /**
     * Determines if a specified string is in this language.
     * @param candidate the string to check
     * @return true if the string is in the language,
     *         false if not in the language or the parameter is null
     */
    public boolean includes(final String candidate) {
        boolean check = false;

        if (candidate.equals(null)) {
            return check;
        }
        else if (strings.contains(candidate)) {
            check = true;
            return check;
        }

        return check;
    }

    /**
     * Ensures that this language includes the given string
     * (adds it if necessary).
     * @param memberString the string to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addString(final String memberString) {

        strings.add(memberString);

        if (strings.contains(memberString)) {
            return true;
        }
        return false;
    }

    /**
     * Ensures that this language includes all of the strings
     * in the given parameter (adds any as necessary).
     * @param memberStrings the strings to be included in the language
     * @return true if this language changed as a result of the call
     */
    public boolean addAllStrings(final Collection<String> memberStrings) {

            int count = strings.size();
            strings.addAll(memberStrings);
            if (count < strings.size()) {
                return true;
            }
            return false;
    }

    /**
     * Provides an iterator over the strings in this language.
     * @return an iterator over the strings in this language in ascending order
     */
    public Iterator<String> iterator() {
        Iterator recur = strings.iterator();
        return recur;
    }

    /**
     * Creates a language that is the concatenation of this language
     * with another language.
     * @param language the language to be concatenated to this language
     * @return the concatenation of this language with the parameter language
     */
    public Language concatenate(final Language language) {

        if (language.isEmpty()) {
           return language;
        }

        language.addAllStrings(strings);

        return language;

    }

    @Override
    public boolean equals(final Object obj) {
        System.out.println(strings);
        if (obj instanceof Language) {
            return true;
        }
        if (obj.hashCode() == strings.hashCode()) {
            if(obj.equals(strings)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    @Override
    public int hashCode() {
        int hash = 9;
        hash = 19 * hash + strings.hashCode();
        return hash;
    }
}