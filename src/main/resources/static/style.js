document.addEventListener("DOMContentLoaded", function() {
    var searchIcon = document.getElementById("search-icon");
    var searchBar = document.getElementById("search-bar");

    searchIcon.addEventListener("click", function() {
        if (searchBar.style.display === "none" || searchBar.style.display === "") {
            searchBar.style.display = "block";
        } else {
            searchBar.style.display = "none";
        }
    });
});
