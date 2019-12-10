import java.util.Scanner;

class SNCOUP_2 {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine()),n,ans,count;

		while(t-->0)
		{
			n = Integer.parseInt(sc.nextLine());
			ans = 0;
			char[][] ch = new char[2][n+2];

			ch[0] = sc.nextLine().toCharArray();
			ch[1] = sc.nextLine().toCharArray();

			boolean hor = false,up=false,down=false;
			count = 0;

			for(int i=0;i<n;i++)
			{
				if(ch[0][i]=='*')
					up = true;
				if(ch[1][i]=='*')
					down = true;
				if(ch[0][i]=='*' || ch[1][i]=='*')
					count++;
				if(ch[0][i]=='*' && ch[1][i]=='*')
					hor = true;
			}
			ans = count-1;

			if(up && down)
				ans=1;

			if(up && down)
			{
				up = false;
				down = false;

				for(int i=0;i<n;i++)
				{
					if(up && ch[0][i]=='*')
					{
						ans++;
						up = false;
						down = false;
					}
					else if(down && ch[1][i]=='*')
					{
						ans++;
						up = false;
						down = false;
					}

					if(ch[0][i]=='*')
						up = true;
					if(ch[1][i]=='*')
						down = true;
				}
			}

			if(!hor)
				ans = Math.min(ans, count-1);

			ans = Math.max(0, ans);

			System.out.println(ans);
		}
		sc.close();
	}
}
