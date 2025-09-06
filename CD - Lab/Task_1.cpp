#include <bits/stdc++.h>
using namespace std;

int main()
{
    string str;
    cout << "\nEnter a sentence: ";
    getline(cin, str);

    stringstream ss(str);
    string word;
    int count = 0;

    while (ss >> word)
    {
        count++;
    }

    cout << "\nTotal words: " << count << endl;
    return 0;
}
