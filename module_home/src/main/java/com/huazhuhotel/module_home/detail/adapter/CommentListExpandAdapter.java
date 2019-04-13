package com.huazhuhotel.module_home.detail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

import java.util.ArrayList;
import java.util.List;

public class CommentListExpandAdapter extends BaseExpandableListAdapter {
    private List<CommentListInfo.ResultBean.CommentsBean> commentsBeanList;
    private Context context;

    LayoutInflater mInflater;

    public CommentListExpandAdapter(Context context) {
        this.commentsBeanList = new ArrayList<>();
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setCommentsBeanList(List<CommentListInfo.ResultBean.CommentsBean> commentsBeanList) {
        this.commentsBeanList = commentsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return commentsBeanList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (commentsBeanList.get(groupPosition).getChild_comments() != null) {
            return commentsBeanList.get(groupPosition).getChild_comments().size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return commentsBeanList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return commentsBeanList.get(groupPosition).getChild_comments().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder group = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_commentgroup, null);
            group = new ViewHolder(convertView);
            convertView.setTag(group);
        } else {
            group = (ViewHolder) convertView.getTag();
        }
        CommentListInfo.ResultBean.CommentsBean commentsBean= commentsBeanList.get(groupPosition);
        StringBuilder stringBuilder = new StringBuilder();
        if (commentsBean!= null) {
            if (commentsBean.getU() != null) {
                group.mItemCommentgroupName.setText(commentsBean.getU().getN());
                ArmsUtils.getImageLoader(context)
                        .loadImage(context, ImageConfigImpl.builder()
                                .url(commentsBean.getU().getP())
                                .imageView(group.mItemCommentgroupImg)
                                .build());
            }
            List<CommentListInfo.ResultBean.CommentsBean.ContentBean> contentBeanXES = commentsBean.getContent();
            if (contentBeanXES != null && contentBeanXES.size() > 0) {
                for (int i = 0; i < contentBeanXES.size(); i++) {
                    stringBuilder.append(contentBeanXES.get(i).getC());
                }
            }

        }
        group.mItemCommentgroupContent.setText(stringBuilder.toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewChildHolder group = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_commentchild, null);
            group = new ViewChildHolder(convertView);
            convertView.setTag(group);
        } else {
            group = (ViewChildHolder) convertView.getTag();
        }
        StringBuilder stringBuilder = new StringBuilder();

        if (commentsBeanList.get(groupPosition).getChild_comments().get(childPosition) != null) {
            if (commentsBeanList.get(groupPosition).getChild_comments().get(childPosition).getU() != null) {
                stringBuilder.append(commentsBeanList.get(groupPosition).getChild_comments().get(childPosition).getU().getN());
            }
            List<CommentListInfo.ResultBean.CommentsBean.ChildCommentsBean.ContentBeanX> contentBeanXES
                    = commentsBeanList.get(groupPosition).getChild_comments().get(childPosition).getContent();
            if (contentBeanXES != null && contentBeanXES.size() > 0) {
                for (int i = 0; i < contentBeanXES.size(); i++) {
                    stringBuilder.append(contentBeanXES.get(i).getC());
                }
            }

        }
        group.mItemCommentChildContent.setText(stringBuilder.toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class ViewChildHolder {
        View view;
        TextView mItemCommentChildContent;

        ViewChildHolder(View view) {
            this.view = view;
            this.mItemCommentChildContent = (TextView) view.findViewById(R.id.item_comment_child_content);
        }
    }

    static class ViewHolder {
        View view;
        ImageView mItemCommentgroupImg;
        TextView mItemCommentgroupName;
        TextView mItemCommentgroupStar;
        TextView mItemCommentgroupMsg;
        TextView mItemCommentgroupContent;

        ViewHolder(View view)  {
            this.view = view;
            this.mItemCommentgroupImg = (ImageView) view.findViewById(R.id.item_commentgroup_img);
            this.mItemCommentgroupName = (TextView) view.findViewById(R.id.item_commentgroup_name);
            this.mItemCommentgroupStar = (TextView) view.findViewById(R.id.item_commentgroup_star);
            this.mItemCommentgroupMsg = (TextView) view.findViewById(R.id.item_commentgroup_msg);
            this.mItemCommentgroupContent = (TextView) view.findViewById(R.id.item_commentgroup_content);
        }
    }
}
