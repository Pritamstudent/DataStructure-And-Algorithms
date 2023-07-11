boolean choice = true;
        while (choice) {
            System.out.println("enter the nodes between which edges are present (between 0 and 5 , both inclusive) ");
            n = s.nextInt();
            m = s.nextInt();
            addEdge(adj, n, m);
            System.out.println("enter true to add more edges and false to exit");
            choice = s.nextBoolean();
        }