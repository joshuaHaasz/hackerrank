'''
Created on 7 Feb 2020

@author: Joshua
'''

from pathlib import Path

def substrCount(n, s):
    
    memory = [0] * 4
    palins = {}
    count = 0
    for i in range(len(s)):
        print("Test string: ", s)
        print("s[i]: ", s[i])
        print("memory :",memory)
        print("palins: ", palins)
        memory, palins = mem_shift(s[i], memory, palins)
        count += memory[1]
        print("memory :",memory)
        print("palins: ",palins)
        if s[i] in palins and memory[1] <= palins[s[i]]:
            count += 1
            if memory[1] == palins[s[i]]:
                del palins[s[i]]
        print("count: ",count)
        print()
    print(count)
    return count
        
def mem_shift(c, mem, palins):
    if mem[0] == 0:
        mem[0], mem[1] = c, 1
    elif mem[2] == 0:
        if c == mem[0]:
            mem[1] += 1
        else:
            palins[mem[0]] = mem[1]
            mem = [c,1,mem[0],0]
    else:
        if c == mem[0]:
            mem[1] += 1
            if mem[2] is not None and mem[2] in palins:
                del palins[mem[2]]
        elif c == mem[2]:
            palins[mem[0]] = mem[1]
            mem = [c, 1, mem[0], 0]
        else:
            palins[mem[0]] = mem[1]
            if mem[2] is not None and mem[2] in palins:
                del palins[mem[2]]
            mem = [c,1,mem[0], 0]
    return mem, palins

if __name__ == "__main__":
    file = Path('../resources/specialstrings.txt')
    with open(file) as f:
        s = f.read()
    print(s)
    n = len(s)
    substrCount(n,s)