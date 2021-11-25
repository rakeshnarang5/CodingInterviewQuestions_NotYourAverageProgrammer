
public class Main
{
	public static void main(String[] args) {
		String input = "#softwareengineering #softwaredeveloper #programming #softwareengineer #software #coding #softwaredevelopment #programmer #developer #computerscience #javascript #coder #engineering #webdevelopment #python #java #webdeveloper #codinglife #html #programmers #programminglife #technology #css #developers #code #programmerlife #coders #softwaretesting #coderlife #bhfyp";
		String[] split = input.split("#");
		StringBuilder output = new StringBuilder();
		for(int i = 1 ; i < split.length ; i++) {
		    output.append(split[i]);
		    if(i != split.length-1){
		        output.append(",");
		    }
		}
		System.out.println(output);
	}
}
