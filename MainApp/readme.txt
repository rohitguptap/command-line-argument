Simple command line application with database access

Main functionality:
- command line driven (main class:  MainApp)
- based on input switch, do one of the following:
  (1) provide help/usage info
  (2) read a server "specification" from a file on local disk (e.g. see server_definition.xml) and persist it to the SERVER database table
  (3) count the number of servers currently persisted in the database
  (4) list persisted servers
  (5) delete a persisted server (id of server to delete to be passed in as a command line arg)
  (6) edit name of persisted server (takes command line args to identify id of server and new name)

Additional requirements:
- add unit tests
- ant-based build to do compilation, run tests and produce junit report and runnable jar (you'll need to download ant separately)



Notes:
- project "skeleton" is provided - feel free to refactor any existing skeleton code or add in other dependencies
- if you want, feel free to use an IDE - preferably one of IntelliJ IDEA, Eclipse, or NetBeans so we can have it installed here
  (if you can bring in a laptop, then use whatever IDE you like)
- use JDK 1.6
- use of JDBC rather than Hibernate is fine






