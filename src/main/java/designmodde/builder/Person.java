package designmodde.builder;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription
 */

public class Person {
    // 必填参数
    private String name;
    // 选填参数
    private String eyes;
    private String mouth;
    private String ears;
    private String nose;

    public Person(Builder builder) {
        this.name = builder.name;
        this.eyes = builder.eyes;
        this.mouth = builder.mouth;
        this.ears = builder.ears;
        this.nose = builder.nose;
    }


    public static class Builder {
        // 必填参数
        private final String name;
        // 选填参数
        private String eyes;
        private String mouth;
        private String ears;
        private String nose;

        public Builder(String name) {
            this.name = name;
        }

        public Builder eyes(String eyes) {
            this.eyes = eyes;
            return this;
        }

        public Builder mouth(String mouth) {
            this.mouth = mouth;
            return this;
        }

        public Builder ears(String ears) {
            this.ears = ears;
            return this;
        }

        public Builder nose(String nose) {
            this.nose = nose;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", eyes='" + eyes + '\'' +
                ", mouth='" + mouth + '\'' +
                ", ears='" + ears + '\'' +
                ", nose='" + nose + '\'' +
                '}';
    }
}
