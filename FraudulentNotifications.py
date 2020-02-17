'''
Created on 5 Feb 2020

@author: Joshua
'''

from pathlib import Path

def activityNotifications(expenditure, d):
    n = len(expenditure)
    i = 0
    count = 0
    while i < n - d:
        slice_arr = sorted(expenditure[i:i+d])
        print("slice_arr", expenditure[i:i+d])
        if d%2 == 1:
            med = slice_arr[d//2]
        else:
            med = (slice_arr[d//2 - 1] + slice_arr[d//2])/2
        print ("med", med)
        print(" expenditure", expenditure[i + d] )
        if expenditure[i + d] >= 2 * med:
            count += 1
        i += 1
    return count

if __name__ == "__main__":
    file = Path("C:/Users/Joshua/eclipse-workspace/hackerrank/resources/fraudulent_notifications")
    with open(file) as f:
        
    