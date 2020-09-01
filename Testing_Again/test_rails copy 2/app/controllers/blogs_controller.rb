class BlogsController < ApplicationController
  def index
  end
def new
end
  def create
   @blog= Blog.new(blog_params)
    @blog.save
    redirect_to blogs_path
  end
  private
  def blog_params
    params.require(:blog).permit(:title,:description)
  end
end
