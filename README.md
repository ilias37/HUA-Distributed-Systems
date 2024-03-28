The purpose is to create a platform that settles contracts between real estate buyers and notaries.

### Run the app

Step 1: Run from terminal
```bash
docker run --name spb_db --rm -e  POSTGRES_PASSWORD=pass123 -e POSTGRES_DB=taxSys --net=host -v pgdata14:/var/lib/postgresql/data  -d postgres:14
```
Step 2: Run the project from your IDE

Step 3: Run the assets/db/users.sql from a database editor

## Remove db data
```bash
docker volume rm pgdata14
```

## App's users
| USERS   | PASSWORD | ROLES       |
|---------|----------|-------------|
| actor1  | pass123  | ROLE_ACTOR  |
| actor2  | pass123  | ROLE_ACTOR  |
| actor3  | pass123  | ROLE_ACTOR  |
| actor4  | pass123  | ROLE_ACTOR  |
| notary1 | pass123  | ROLE_NOTARY |
| notary2 | pass123  | ROLE_NOTARY |
| notary3 | pass123  | ROLE_NOTARY |
| admin1  | pass123  | ROLE_ADMIN  |
| admin2  | pass123  | ROLE_ADMIN  |



## Links:
* [install docker](https://tinyurl.com/2m3bhahn)
