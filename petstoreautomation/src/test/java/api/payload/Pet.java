package api.payload;

import java.util.ArrayList;
import java.util.List;

public class Pet {
	
	int id;
	private Category category;
	private String name;
	private ArrayList<String> photoUrls;
	private ArrayList<Tags> tags;
	private String status;

    // Constructors, getters, and setters

    public Pet() {
    }



    public Pet(int id, Category category, String name, ArrayList<String> photoUrls, ArrayList<Tags> tags,
			String status) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}

    


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<String> getPhotoUrls() {
		return photoUrls;
	}



	public void setPhotoUrls(ArrayList<String> photoUrls) {
		this.photoUrls = photoUrls;
	}



	public ArrayList<Tags> getTags() {
		return tags;
	}



	public void setTags(ArrayList<Tags> tags) {
		this.tags = tags;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}




	public static class Category {
        private int id_t;
        private String name_ct;
        
        
        
		public Category() {
			
		}

		public Category(int id_t, String name_ct) {
			super();
			this.id_t = id_t;
			this.name_ct = name_ct;
		}

		public int getId_t() {
			return id_t;
		}

		public void setId_t(int id_t) {
			this.id_t = id_t;
		}

		public String getName_ct() {
			return name_ct;
		}

		public void setName_ct(String name_ct) {
			this.name_ct = name_ct;
		}
        
        

    }

    public static class Tags {
        private int id_t;
        private String name_t;
        
		public Tags(int id_t, String name_t) {
			super();
			this.id_t = id_t;
			this.name_t = name_t;
		}

		public int getId_t() {
			return id_t;
		}

		public void setId_t(int id_t) {
			this.id_t = id_t;
		}

		public String getName_t() {
			return name_t;
		}

		public void setName_t(String name_t) {
			this.name_t = name_t;
		}
        
        

    }

}
