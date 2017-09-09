int a(int y){
  return y + 2;
}

int b(int x){
  return a(x) + 8;
}

int main(int argc,char** argv){
  return b(7) +2;
}
