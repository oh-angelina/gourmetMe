package com.angelinaopoku.gourmetMe.blogpost;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogPostController {
	
	@Autowired
    private BlogPostRepository blogPostRepository;
	
	private BlogPost blogPost;
	
	 @RequestMapping("/")
	 public String defectDetails() {
	 return "blogpost/index";
	 }

 @GetMapping("/blog_posts/all-posts")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", blogPostRepository.findAll());
		return "blogpost/all-posts";
		}
 
 @PostMapping(value = "/result")
 	public String saveBlogPost(@ModelAttribute("blogPost") BlogPost blogPost, Model model) {
	 
		blogPostRepository.save(blogPost); 
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("restaurant", blogPost.getRestaurant());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	    }
 
 @GetMapping(value = "/blog_posts/post")
 	public String newBlog (Model model) {
	 BlogPost blogPost = new BlogPost();
	 model.addAttribute("blogPost", blogPost);
	 return "blogpost/post";
 }
 @GetMapping("/blog_posts/update/{id}")
 public String updatePostWithId(@PathVariable Long id, Model model) {
	 //Get the post
	 Optional<BlogPost> result = blogPostRepository.findById(id);
	 BlogPost blogPost = null; 
	 
	 if (result.isPresent()) {
		 blogPost = result.get();
	} else {
		throw new RuntimeException("Did not find post id - " + id); 
	}
	 //Set the post as a model attribute
	 model.addAttribute("blogPost", blogPost);
	 return "blogpost/post";
 }
 
	 @PostMapping(value = "/blog_posts/post")
	 public String create(BlogPost blogPost, Model model) {
	 	blogPostRepository.save(blogPost);
	 	model.addAttribute("title", blogPost.getTitle());
	 	model.addAttribute("author", blogPost.getAuthor());
	 	model.addAttribute("restaurant", blogPost.getRestaurant());
	         model.addAttribute("blogEntry", blogPost.getBlogEntry());
	         return "blogpost/result";
	 }
	 
	 @GetMapping("/blog_posts/delete/{id}")
	 public String deletePostWithId(@PathVariable Long id) {
		 blogPostRepository.deleteById(id);
		 return "redirect:/";
	 }
	 
	 
	 // Use this language to update all links

}
    

