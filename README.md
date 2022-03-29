# PAO


Reading tracker like goodreads/myanimelist


USER
	- id (unique)
	- email address
	- username (not unique)
	- birthday
	- age (calculated)
	- Reading list[]

	functions:
	- get and set
	- calculate an user's age based on the birthday
	- calculate how much time they spend reading( in total and in a period of time )( 2 minutes per page for example )
	- calculate how many books they are reading 
	- calculate how many books they completed
	- calculate how many books they dropped
	- calculate how many books they plan to read


AUTHOR
	- type (novelist,poet,illustrator,writer) (poate fi mai multe)
	- name
	- country of origin
	- Book books[]

	functions:
	- get and set


BOOK (nu poate fi instantiata)
	- title
	- pages
	- language

	functions:
	- get and set
	- calculate how popular it is ( how many people read it and the average score)

NOVEL extends BOOK
	- Author novelist
	- number of chapters

	functions:
	- get and set
	- calculate how popular it is ( overwrite to compare it to the rest of the novels )
	( ex BOOK1 was read by 300 people out of 1500 who read novels)
	( placement: top 10, top 15, top 50, top 100)


POETRY extends BOOK
	- Author poet
	- number of poems

	functions:
	- get and set
	- calculate how popular it is ( overwrite to compare it to the rest of the poetry books )
	( ex BOOK1 has a score of 3.5, compared to the average of 3 for the rest of the poetry books )

COMICS extends BOOK
	- Author illustrator
	- Author writer
	- number of volumes

	functions:
	- get and set
	- calculate how popular it is ( overwrite to compare it to the rest of the comics )
	( ex compare how many people read it and the average score )
	- calculate the average age of the readers

ILLUSTRATION BOOK extends BOOK
	- Author illustrator

	functions:
	- get and set
	- calculate how popular it is ( overwrite to compare it to the rest of the illustration books )
	( ex compare how many people read it )
	- find out if the illustrator has any comics made and what those are

	
READING LIST
	- Book book
	- number of pages read (verify its its bigger than the number of pages the book has)
	- state ( completed/reading/dropped/plan to read )
	- reading start date
	- reading end date
	- score (1-5 stars)

	functions:
	- get and set
