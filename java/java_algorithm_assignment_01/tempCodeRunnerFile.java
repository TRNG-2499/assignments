        System.out.println(customStart(2,3,4,2,7,6));
        System.out.println(customStart(1,3,2,5,4));
        System.out.println(customStart(1,3,1,4,2));
        System.out.println(customStart(1,5,4,1,2));
        System.out.println(missingNo(3,2,5,4));
        System.out.println(missingNo(3,1,4,2));
        System.out.println(missingNo(5,4,1,2,2));

        int[] test = twoMissing(5,6,3,4,2);
        for (int i : test) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println(twoMissing(5,6,3,4,2).toString());
        System.out.println(twoMissing(7,6,3,4,5).toString());
        System.out.println(twoMissing(3,4,2,7,6).toString());