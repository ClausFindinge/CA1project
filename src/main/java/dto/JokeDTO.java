package dto;


import entities.Joke;



public class JokeDTO {
   private Long id;
    private String type;
    private String joke;
    private int funnyness;
    private String description;

    public JokeDTO(Joke joke) {
        this.id = joke.getId();
        this.type = joke.getType();
        this.joke = joke.getJoke();
        this.funnyness = joke.getFunnyness();
        this.description = joke.getDescription();
    }
// getters to fill table. 
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getJoke() {
        return joke;
    }

    public int getFunnyness() {
        return funnyness;
    }
    
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "JokeDTO{" + "id=" + id + ", type=" + type + ", joke=" + joke + ", funnyness=" + funnyness + ", description=" + description + '}';
    }

 
}

