/*
Скрипт заполняет таблицу все поля в шапке и таблицу About User для /admin и /user
 */

$(async function() {
    await thisUser();
});
async function thisUser() {
    fetch("http://localhost:8080/api/user")
        .then(res => res.json())
        .then(data => {
            // Добавляем информацию в шапку
            $('#headerUsername').append(data.email);
            let roles = data.roles.map(role => " " + role.name.substring(5));
            $('#headerRoles').append(roles);

            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.username}</td>
                <td>${data.lastName}</td>
                <td>${data.age}</td>
                <td>${data.email}</td>
                <td>${roles}</td>)`;
            $('#userPanelBody').append(user);
        })
}