import glob
import pandas as pd
from pandas import Series, DataFrame


all_dfs = []

for one_file in glob.glob('The_Finals_Ranked*.csv'):
    new_df = pd.read_csv(one_file)
    all_dfs.append(new_df)
    
df = pd.concat(all_dfs)

name = input('Enter Name: ')

print(df[df['Steam Name'] == name])
