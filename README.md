

```bash
sudo -u postgres -i
psql
CREATE DATABASE test;
\c test;
CREATE TABLE test(a NUMERIC, b NUMERIC, c NUMERIC);
```

To compile:
```bash 
make
```

To execute:
```bash
make run
```
