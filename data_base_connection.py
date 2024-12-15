import dotenv
from sqlalchemy import create_engine, URL


def DatabaseConnection() -> object:
    url = URL.create(
            drivername='postgresql+psycopg2',
            username='postgres',
            password='xpress11',
            host='localhost',
            port='5432',
            database='bank_statistics'
            )

    engine = create_engine(url)
    return engine