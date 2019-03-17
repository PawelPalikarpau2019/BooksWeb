# BooksWeb

To build the project use following command:<br/>
**mvn clean package**

After building the application run following command to start it:<br/>
**java -jar target/books-web-1.0.jar**

_By default the program will grab the default file from resources folder._

If you want to run the project with your own “books.json” file just type path to your file as the first argument. For example:<br/>
**java -jar target/books-web-1.0.jar D:\homework\myOwnBooksFile.json**

The application starts on localhost:8080 and has only three endpoint:
* /api/book/{isbn} - _http://localhost:8080/api/book/9781592432172_
* /api/category/{categoryName}/books - http://localhost:8080/api/category/Computers/books
* /api/rating - http://localhost:8080/api/rating

All endpoints return result in JSON format.
Any book from returned result is not the original data from the file. It was converted to another simplified object.

First endpoint will return a book for such ISBN code. If book with such ISBN was not found, the application will try to find a book for such ID. If then nothing will be found the application will return 404 – “No results found”.
Second endpoint will return all found books with provided category name. If none book was found, then empty array will be returned.
Third endpoint will return you author names with their average rating ordered descending by their average rating. If any book does not contains author or rating, it wouldn’t be added to the result.

You can find:<br/>
ISBN - **item.volumeInfo.industryIdentifiers list under "type": "ISBN_13"**<br/>
ID – **item.id**<br/>
Category - **item.volumeInfo.categories**<br/>
Authors - **item.volumeInfo.authors**<br/>
Rating - **item.volumeInfo.averageRating**
