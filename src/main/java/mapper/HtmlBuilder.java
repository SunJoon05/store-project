package mapper;

import model.entities.User;
import repository.UserImplementation;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class HtmlBuilder {

    private final UserImplementation USER_DAO = new UserImplementation();

    private String renderUserRow(User entity) {
        return """
                <tr class="users__management-row">
                    <td class="users__management-data">#%s</td>
                    <td class="users__management-data">%s</td>
                    <td class="users__management-data">%s</td>
                    <td class="users__management-data">%s</td>
                    <td class="users__management-data">%s</td>
                    <td class="users__management-data">%s</td>
                    <td class="users__management-data --user-state">%s</td>
                    <td class="users__management-data">
                        <button class="user__management-action">
                            <svg  xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                  fill="currentColor" viewBox="0 0 24 24" >
                                <path d="M17 6V4c0-1.1-.9-2-2-2H9c-1.1 0-2 .9-2 2v2H2v2h2v12c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V8h2V6zM9 4h6v2H9zM6 20V8h12v12z"></path><path d="M9 10h2v8H9zm4 0h2v8h-2z"></path>
                            </svg>
                        </button>
                        <button class="user__management-action">
                            <svg  xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                  fill="currentColor" viewBox="0 0 24 24" >
                                <path d="M17 17.76v-5.35l2.91-2.91L21 8.41c.38-.38.58-.88.58-1.42s-.21-1.04-.59-1.41L18.4 3c-.38-.38-.88-.58-1.41-.58s-1.04.21-1.41.59L13.8 4.8l-2.21 2.21H6.24l-3.35 12.3 1.82 1.82 12.3-3.35Zm0-13.35 2.59 2.58-1.09 1.09-2.59-2.59 1.08-1.08ZM7.77 9h4.65l2.09-2.09L17.1 9.5l-2.09 2.09v4.65L7 18.42l3.43-3.43h.08c.83 0 1.5-.67 1.5-1.5s-.67-1.5-1.5-1.5-1.5.67-1.5 1.5v.08L5.58 17l2.18-8.01Z"></path>
                            </svg>
                        </button>
                    </td>
                </tr>
                """.formatted(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getPhone(), entity.getRegisterDate(), entity.getRole().getTag(), entity.getState() ? "Active" : "Inactive");
    }

    public List<String> buildTableRows() throws SQLException {
        List<User> users = this.USER_DAO.findAll();

        if (users.isEmpty()) return List.of();

        return users
                .stream().map(this::renderUserRow)
                .collect(Collectors.toList());
    }
}
