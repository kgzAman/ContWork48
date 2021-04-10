package edu.company.Aman.Server;

import edu.company.Aman.Generator;

import java.util.Random;

public class Task {
        private String name;
        private String description;
        private Category category;

        public Task(){
            this.description = Generator.makeDescription();
            this.name = Generator.makeName();
            Random r = new Random();
            int a = r.nextInt(1)+3;
            switch (a) {
                case 1 -> this.category = Category.WORK;
                case 2 -> this.category = Category.ORDINARY;
                case 3 -> this.category = Category.SHOPPING;
            }
        }
        public void makeCategory(){

        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String toString (){
            String n = "";
            n =  String.format("%s | %s | %s", this.name, this.description, this.category);
            return n;
        }
}
