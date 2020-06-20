#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <string.h>

#define N 10010

using namespace std;

int main()
{
    char s[N];
    int Max;
    gets(s);
    scanf("%d", &Max);

    int len = strlen(s);

    int m = 0, i =0;
    char ch[N]="";

    while(i < len)
    {
        if(m < Max-1)
        {
            ch[m++] = s[i];
            i++;
        }
        else if(m == Max-1)
        {
            if(i == len-1)
            {
                ch[m++] = s[i];
                i++;
            }
            else if(s[i] == ' ')//放空格
            {
                ch[m++] = s[i];
                i++;
            }
            else if( (s[i]!=' ' &&  s[i+1]!=' '))//放连接符 -
            {
                if(i-1>0 && s[i-1] != ' ')
                    ch[m++] = '-';
            }
            else if(s[i+1] == ' ')//放原来字符
            {
                ch[m++] = s[i];
            }

            //puts(ch);
            printf("{");
            for(int j=0; j<m; j++)
                printf("%c", ch[j]);
            printf("}\n");
            memset(ch, 0, sizeof(ch));
            m = 0;
        }
    }
    if(m!=0)
    {
        printf("{");
        for(int j=0; j<m; j++)
            printf("%c", ch[j]);
        printf("}\n");
    }
    //printf("\n");

    return 0;
}

