In some cases, you may required to insert a batch of records into database in one 
shot. If you call a single insert method for every record, the SQL statement will be 
compiled repeatedly and causing your system slow to perform.

In above case, you can use JdbcTemplate batchUpdate() method to perform the batch 
insert operations. With this method, the statement is compiled only once and 
executed multiple times.