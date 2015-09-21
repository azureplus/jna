#include<stdio.h>
long add(int a,long b);
long add(int a,long b)
{
      long s = 0;
      for(int i=0;i<b;i++)
      {
          s += a;
      }
      return s ;
}