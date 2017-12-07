public class Main {

    public static void main(String[] args) {
//        try {
//            HttpUtils.init();
//            new GetSJTokenJob().execute(null);
//            Thread.sleep(5*1000);
//            new GetSJDatasJob().execute(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        double a = 0.032;
//        double b = 3.12;
//        System.out.println(0.02+0.12);
//        System.out.println(MathUtils.add(0.02,0.12));
//        System.out.println(MathUtils.sub(0.02,0.12));
//        System.out.println(MathUtils.multiply(0.02,0.12));
//        System.out.println(MathUtils.div(0.02,0.12));

//        List<User> userList = new ArrayList<User>();
//        userList.add(new User("joker",20));
//        userList.add(new User("simon",30));
//        userList.add(new User("bake",30));
//
//        List<String> nameList = userList.stream().map(user -> user.getName()).collect(Collectors.toList());
//        String[] nameArray = nameList.toArray(new String[nameList.size()]);
//        for(int i=0;i<nameArray.length;i++){
//            System.out.println( nameArray[i]);
//        }

    }

    public static class User{
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
