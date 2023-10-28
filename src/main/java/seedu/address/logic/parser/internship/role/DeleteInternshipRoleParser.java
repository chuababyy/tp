package seedu.address.logic.parser.internship.role;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.internship.role.DeleteInternshipRoleCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new DeleteInternshipRoleCommand object
 */
public class DeleteInternshipRoleParser implements Parser<DeleteInternshipRoleCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteInternshipRoleCommand
     * and returns a DeleteInternshipRoleCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteInternshipRoleCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteInternshipRoleCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteInternshipRoleCommand.MESSAGE_USAGE), pe);
        }
    }
}