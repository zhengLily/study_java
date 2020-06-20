#include<iostream>
#include<memory>//auto_ptr��ͷ�ļ�
using namespace std;
class Test
{
public:
    Test(string s)
    {
        str = s;
       cout<<"Test creat\n";
    }
    ~Test()
    {
        cout<<"Test delete:"<<str<<endl;
    }
    string& getStr()
    {
        return str;
    }
    void setStr(string s)
    {
        str = s;
    }
    void print()
    {
        cout<<str<<endl;
    }
private:
    string str;
};


int main()
{
    Ptr<Test> ptest(new Test("123"));//���ù��캯�����Test creat
    ptest->setStr("hello ");//�޸ĳ�Ա������ֵ
    ptest->print();//���hello
    ptest.get()->print();//���hello
    ptest->getStr() += "world !";
    (*ptest).print();//���hello world
    ptest.reset(new Test("123"));//��Ա����reset()���°�ָ��Ķ��󣬶�ԭ���Ķ�����ᱻ�ͷţ�������������һ�ι��캯�������е���һ�����������ͷŵ�֮ǰ�Ķ���
    ptest->print();//���123
    return 0;//��ʱ��ʣ��һ�����󣬵���һ�����������ͷŸö���
}
