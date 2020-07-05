package com.company.list;

public class FactoryData {

    private int ab;

    public General getInstance(String a){
        return new Data(a);
    }

    private static class Data implements General {
        private String a;

        public Data(String a) {
            this.a = a;
        }

        @Override
        public void execute() {
            System.out.println("Hello " + a);
        }

        @Override
        public void ex() {

        }
    }
}
