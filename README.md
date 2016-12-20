# DataSpread Software Release 

DataSpread is a _spreadsheet-database hybrid system_, with a spreadsheet frontend, and a database backend. Thus, DataSpread inherits the flexibility and ease-of-use of spreadsheets, as well as the scalability and power of databases. DataSpread is a multi-year project, supported by the National Science Foundation via award number 1633755.

### Version
The current version is 1.0.0.

### Features
DataSpread is built using [PostgreSQL][postgressite] and [ZKSpreadsheet][zksite], an open-source web-based spreadsheet tool.

DataSpread's version 1.0.0 allows users to scale to billions of cells and return results for common spreadsheet operations within seconds. It does so via on-demand loading of spreadsheet data.

Like traditional spreadsheet software, DataSpread will auto-save spreadsheet books; and supports standard spreadsheet book and sheet  operations like Load, Rename, Delete, and Import (via XLS and XLSX, and CSV). 

Like traditional spreadsheet software, DataSpread supports the use of 225+ spreadsheet functions, along with formatting and styling operations. It also supports row and column operations like insert, delete, cut, copy, and paste; during insertion and deletion, formulae are updated as is the case in traditional spreadsheet software.

### Key Design Innovations
* DataSpread employs a _flexible hybrid data model_ to represent spreadsheet data within a database. 
* DataSpread uses _positional indexing techniques_ to both locate data by position, and keep it up-to-date as the data is updated. 
* DataSpread also employs a _LRU caching mechanism_ to retrieve and keep in memory data from the database on demand. 
* DataSpread also employs _speculative fetching_ to fetch additional data beyond the user's current spreadsheet window. 



### System Requirements
If you are intending to install DataSpread locally, you need to have installed the following software:
* PostgreSQL >= 9.5
* Tomcat 8.5.4
* Java 8


### Installation Instructions
You can directly use DataSpread via our cloud-hosted [site][siteinfo].

Alternatively, you can install DataSpread by following these instructions:
```
... Instructions ...
```
The `SELECT` command allows you to..

### Usage Instructions
DataSpread supports the use of formulae, just like other spreadsheets, using syntax like:
```
...
```
In addition, DataSpread allows users to issue SQL commands, using syntax like:
```
...
```

### Known Issues
* sheet scrolling has a delay in display
* sorting not working
* copy sheet not working


### Planned Releases




License
----
MIT


[siteinfo]: http://kite.cs.illinois.edu:8080
[zksite]: https://www.zkoss.org/product/zkspreadsheet
[postgressite]: https://www.postgresql.org/
