Lecture 24

  1. When you write responsive design by hand, what you can do is to use @media to seperate different kinds of layout and then write something like this:
      @media (min-width: 1200px) {
        .col-lg-1, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, ...., .col-lg-12 {
          float: left;
          border: 1px solid green;
        }

        .col-lg-1 {
          width: x%;
        }
        ..
        ...
      }
