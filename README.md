# coorge_user_transaction_ms

* Handles user and transaction related data.

* For info on API's please follow

    [swagger](./swagger.yaml)

* Auth is being handled by [AuthFilter](./src/main/java/com/coorge/userandtransaction/filter/AuthFilter.java) which is a customer filter , add random UUID as auth token.


##TODO
Global Exception Handler

Return response object instead of strings

Test Cases


docker-compose build

docker-compose up