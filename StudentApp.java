/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StudentApp;

interface ArticleScoreBehaviour{
    float articleScore();
}
interface ConferenceScoreBehaviour{
    float conferenceScore();
}
abstract class Student{
    int id;
    float mid;
    float fin;
    public Student(){
    }
    public Student(int id,float mid,float fin){
        this.id=id;
        this.fin=fin;
        this.mid=mid;
    }
    abstract float computeTotalScore();
    float ComputeBaseScore(){
       return (mid*40/100)+(fin*60/100); 
    }
}
interface ProjectScoreBehaviour{
    float projectScore();
}

class MasterStudent extends Student implements ConferenceScoreBehaviour{
    int numberofConf;
    public void MasterStudent(int id,float mid,float fin,int numberofConf){
        this.id=id;
        this.mid=mid;
        this.fin=fin;
        this.numberofConf=numberofConf;
    }
    float computeTotalScore(){
        return ComputeBaseScore()+conferenceScore();
    }
    public float conferenceScore(){
        return numberofConf*5;
    }
    
}
class BachelourStudent extends Student implements ProjectScoreBehaviour{
    public BachelourStudent(int id,float mid,float fin){
        super(id,mid,fin);
    }
    float computeTotalScore(){
        return ComputeBaseScore()+projectScore();
    }
    public float projectScore(){
        return 20;
    }
}
class PHDStudent extends MasterStudent implements ArticleScoreBehaviour{
    int numberofArticles;
    public PHDStudent(int id,float mid,float fin,int numberofArticles){
        this.id=id;
        this.mid=mid;
        this.fin=fin;
        this.numberofArticles=numberofArticles;
    }
    public float computeTotalScore(){
        return ComputeBaseScore()+articleScore();
    }
    public float articleScore(){
        return numberofArticles*8;
    }
}
public class StudentApp{

    
    public static void main(String[] args) {
        PHDStudent phd= new PHDStudent(1,100,100,5);
        System.out.println(phd.articleScore());
        System.out.println(phd.ComputeBaseScore());
        System.out.println(phd.computeTotalScore());
    }
    
}
