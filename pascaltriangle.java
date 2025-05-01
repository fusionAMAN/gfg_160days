import java.util.ArrayList;

public class pascaltriangle {
    ArrayList<Integer>list=new ArrayList<>();
    if(n==0) return new ArrayList<>();
    list.add(1);
    if(n==1)return list;
    list.add(1);
    if(n==2)return list;
    for(int i=2;i<n;i++){
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(1);
        for(int j=1;j<list.size();j++){
            ans.add(list.get(j)+list.get(j-1));
        }
        ans.add(1);
        list=ans;
    }
    return list;
}   
}