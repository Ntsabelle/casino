# casino

Casino application to view balance and transaction.

Below endponts are used to view balance and transactions

API Specification
Base Path: /casino
Get Balance
GET /player/{playerId}/balance
• Invalid playerId should be seen as a bad request (HTTP 400)


Update Balance
POST /player/{playerid}/balance/update
• Invalid playerId should be seen as a bad request (HTTP 400)
• Negative amounts should be seen as a bad request (HTTP 400)
• Wager greater than current balance should be seen as a Teapot (HTTP 418)


Last 10 Transactions
POST /admin/player/transactions
• Invalid username should be seen as a bad request (HTTP 400)

The application is used in build h2 database
