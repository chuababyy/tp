package seedu.address.logic.parser.assignment;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.assignment.Date;
import seedu.address.model.assignment.Description;
import seedu.address.model.assignment.IsoDate;
import seedu.address.model.assignment.Name;
import seedu.address.model.assignment.Status;

/**
 * Utility parser for assignments
 */
public class ParserUtil {
    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * @param name the taskname
     * @return a name object
     * @throws ParseException
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidTaskName(name)) {
            throw new ParseException("Name cannot be empty");
        }
        return new Name(trimmedName);
    }

    /**
     * @param description the description of task
     * @return a description object
     * @throws ParseException
     */
    // Validation required? Currently, d/ is a valid input
    public static Description parseDescription(String description) {
        requireNonNull(description);
        String trimmedDescription = description.trim();
        return new Description(trimmedDescription);
    }

    /**
     * @param status the completion status
     * @return a status object
     * @throws ParseException when input is not done or undone
     */
    public static Status parseStatus(String status) throws ParseException {
        requireNonNull(status);
        String trimmedStatus = status.trim();
        if (!Status.isValidStatus(status)) {
            throw new ParseException("Enter a valid status input: s/done, s/undone");
        }
        return new Status(trimmedStatus.equals("done"));
    }

    /**
     * @param date to be parsed
     * @return a date object
     * @throws ParseException when not in yyyy-mm-dd HH:mm format
     */
    public static Date parseDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDate = date.trim();
        if (!IsoDate.isValidIsoDate(date)) {
            throw new ParseException("Enter date in yyyy-mm-dd HH:mm format");
        }
        return new IsoDate(LocalDateTime.parse(date, DateTimeFormatter.ofPattern(IsoDate.DATE_FORMAT)));
    }

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }
}
