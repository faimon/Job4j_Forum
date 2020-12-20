package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Application;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.MessageService;
import ru.job4j.forum.service.PostService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class PostControlTest {
    @MockBean
    private PostService posts;

    @MockBean
    private MessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void savePost() throws Exception {
        this.mockMvc.perform(post("/edit/")
                .param("topic_id", "1")
                .flashAttr("post", Post.of("Java"))
                .flashAttr("message", new Message("123", "Maria")))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        ArgumentCaptor<Integer> integerArgument = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Message> messageArgumentCaptor = ArgumentCaptor.forClass(Message.class);

        verify(posts).addPost(argument.capture(), integerArgument.capture());
        verify(messageService).addMessage(messageArgumentCaptor.capture(), argument.capture());

        assertThat(argument.getValue().getName(), is("Java"));
        assertThat(integerArgument.getValue(), is(1));
        assertThat(messageArgumentCaptor.getValue().getText(), is("123"));
    }

    @Test
    @WithMockUser
    public void getPost() throws Exception {
        this.mockMvc.perform(get("/post")
                .param("id", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    public void getAddPage() throws Exception {
        this.mockMvc.perform(get("/edit")
        .param("topic_id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }
}
