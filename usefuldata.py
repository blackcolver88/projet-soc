import pandas as pd
from data_base_connection import DatabaseConnection
def rename_columns(df) -> None:
    df.rename(columns={'y': 'subscribed'}, inplace=True)

def main() -> None:

    df = pd.read_csv("bank.csv", delimiter=";")
    
    rename_columns(df)
    
    print("Null values per column:")
    print(df.isnull().sum())
    
    df.dropna(inplace=True)
    
    print("Number of duplicate rows:", df.duplicated().sum())
    df.drop_duplicates(inplace=True)
    
    df.columns = [col.lower() for col in df.columns]
    
    print("\nDataFrame Summary:")
    print(df.describe())
    
    print("\nFirst few rows:")
    print(df.head())
    
    print("\nDataFrame Info:")
    print(df.info())
    df.to_csv("cleaned_bank.csv", index=False, sep=";")
    engine = DatabaseConnection()
    df.to_sql("stats", engine, if_exists='replace', index=False)
    print("Data saved to database.")
if __name__ == "__main__":
    main()
