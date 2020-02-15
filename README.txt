This app contains 2 services product and category, located at these addresses:

http://localhost:8080/product/

http://localhost:9966/category/


To add product or category you need to send POST request to one of the above in JSON format.

For product service it must be these keys in any order:
{
  "name":"value",
  "categoryId":"value"  
} 

categoryId should match with primary key id in category service

For category:
{
  "name":"value"
}

Add category/product:
POST http://localhost:8080/product/
POST http://localhost:9966/category/

Find by id:
GET http://localhost:8080/product/"id"
GET http://localhost:9966/category/"id"

Get all categories/products
GET http://localhost:8080/product/
GET http://localhost:9966/category/
