const table = document.getElementById("jokeTable");


function populateTable()
{
    let urlAll = "/jpa-rest/api/jokes/id";

    fetch(urlAll)
            .then(res => res.json())
            .then(data => {
                console.log("data", data);

                let jokeTable = data.map(joke => "<tr><td>" + joke.id
                            + "</td><td>" + joke.type + "</td><td>" + joke.joke
                            + "</td><td>" + joke.funnyness + "</td><td>" + joke.description
                            + "</td></tr>");
                carTable.unshift("<table><tr><th>Id#</th><th>Type</th>\n\
                                <th>Model</th><th>joke</th><th>Funnyness</th>\n\
                                <th>description</th>");
                jokeTable.push("</table");
                jokeTable = jokeTable.join('');
                table.innerHTML = jokeTable;
            });
}

//
//buttonAll.onclick = function (e)
//{
//    e.preventDefault();
//    populateTable();
//};
//
//buttonSortPrice.addEventListener("click", function ()
//{
//    console.log("");
//    sortTable(4)
//});
//
//buttonSortYear.addEventListener("click", function ()
//{
//    console.log("joke");
//    sortTable(3)
//});
//
//buttonSortMake.addEventListener("click", function ()
//{
//    console.log("funnyness");
//    sortTable(1)
//});
