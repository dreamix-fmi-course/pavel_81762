package labs.collections;

public class Dog implements Comparable<Dog> {
    private String breed;
    private int weight;

    Dog(String breed, int weight){
        this.breed = breed;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Dog o) {
        if(this.weight == o.weight) {
            return 0;
        }else if(this.weight > o.weight) {
            return 1;
        }else{
            return -1;
        }
    }
}
